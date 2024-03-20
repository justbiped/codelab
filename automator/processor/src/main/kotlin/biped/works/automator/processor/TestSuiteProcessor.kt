package biped.works.automator.processor

import com.biped.automator.core.AutomatorRunner
import com.biped.automator.core.Scenario
import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.toClassName
import com.squareup.kotlinpoet.ksp.toTypeName
import com.squareup.kotlinpoet.ksp.toTypeParameterResolver
import com.squareup.kotlinpoet.ksp.writeTo
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

class TestSuiteProcessor(private val environment: SymbolProcessorEnvironment) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val testClassList = resolver.getSymbols(AutomatorRunner::class)
        if (testClassList.none()) return emptyList()

        createTestSuiteFileSpec(testClassList).writeTo(environment.codeGenerator, aggregating = true)
        return emptyList()
    }

    private fun createTestSuiteFileSpec(testScenarios: Sequence<KSClassDeclaration>): FileSpec {
        val pgk = testScenarios.first().toClassName().packageName

        val runWithAnnotation = AnnotationSpec.builder(RunWith::class)
            .addMember("%T::class", Suite::class)
            .build()


        val suiteClasses = getSuiteClasses(testScenarios)

        val suiteFormat = suiteClasses
            .map { _ -> "%L" }
            .joinToString(",\n")

        val suiteClassesBlock = suiteClasses
            .map { CodeBlock.builder().add("%T::class", it).build() }
            .toList()
            .toTypedArray()

        val suiteClassesAnnotationBuilder = AnnotationSpec.builder(SuiteClasses::class)
        suiteClassesAnnotationBuilder.addMember(suiteFormat, *suiteClassesBlock)

        return FileSpec.builder(pgk, "AutomatorTestSuite")
            .addType(
                TypeSpec.classBuilder("AutomatorTestSuite")
                    .addAnnotation(runWithAnnotation)
                    .addAnnotation(suiteClassesAnnotationBuilder.build())
                    .build()
            ).build()
    }

    private fun getSuiteClasses(testScenarios: Sequence<KSClassDeclaration>): Sequence<TypeName> =
        testScenarios
            .sortedBy { it.getScenarioOrder() }
            .mapToTypeName()
}

fun Sequence<KSClassDeclaration>.mapToTypeName(): Sequence<TypeName> {
    return map { it.asStarProjectedType().toTypeName(it.typeParameters.toTypeParameterResolver()) }
}

@OptIn(KspExperimental::class)
fun KSClassDeclaration.getScenarioOrder() = getAnnotationsByType(Scenario::class).firstOrNull()?.order ?: 0