package biped.works.automator.processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSNode
import com.google.devtools.ksp.validate
import kotlin.reflect.KClass

fun Resolver.getSymbols(kClass: KClass<*>) =
    this.getSymbolsWithAnnotation(kClass.qualifiedName.orEmpty())
        .filterIsInstance<KSClassDeclaration>()
        .filter(KSNode::validate)