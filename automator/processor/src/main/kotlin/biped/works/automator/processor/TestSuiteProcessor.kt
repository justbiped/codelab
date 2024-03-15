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
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.ksp.toClassName
import com.squareup.kotlinpoet.ksp.writeTo

class TestSuiteProcessor(private val environment: SymbolProcessorEnvironment) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val testClassList = resolver.getSymbols(AutomatorRunner::class)
        if (testClassList.none()) return emptyList()

        genTestSuite(testClassList).writeTo(environment.codeGenerator, aggregating = true)
        return emptyList()
    }

    override fun onError() {
        super.onError()
    }
}

@OptIn(KspExperimental::class)
fun genTestSuite(testScenarios: Sequence<KSClassDeclaration>): FileSpec {
    val pgk = testScenarios.first().toClassName().packageName

    val classNames = testScenarios
        .sortedBy { it.getAnnotationsByType(Scenario::class).firstOrNull()?.order ?: 0 }
        .joinToString { "${it.toClassName().simpleName}::class" }

    val printFun = FunSpec.builder("printMe").addCode(
        """
        |print("$classNames")
        |""".trimMargin()
    ).build()

    return FileSpec.builder(pgk, "AutomatorTestSuite")
        .addType(
            TypeSpec.classBuilder("AutomatorTestSuite")
                .addFunction(printFun)
                .build()
        ).build()
}