// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val matricula: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel : Nivel) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usr1 = Usuario("José da Silva", 12345)
    val usr2 = Usuario("Maria Costa", 54321)
    val usr3 = Usuario("João Arantes ", 32145)

    val ctd1 = ConteudoEducacional("Metodologias do Plataforma" )
    val ctd2 = ConteudoEducacional("Instalação da máquina Virtual", 30 )
    val ctd3 = ConteudoEducacional("Estruturas de Repetição em Java", 120 )

    val conteudosForm1 = listOf<ConteudoEducacional>(ctd1, ctd2)
    val conteudosForm2 = listOf<ConteudoEducacional>(ctd1, ctd3)

    val form1 = Formacao("Linux Fundamentos", conteudosForm1, Nivel.INTERMEDIARIO )
    val form2 = Formacao("Java Básico", conteudosForm2, Nivel.BASICO)

    form1.matricular(usr1)
    form2.matricular(usr2)
    form2.matricular(usr3)

    println(form1.nome)
    for( ctd in form1.conteudos ) println("conteudo ${ctd.nome}, duracao: ${ctd.duracao}")

    for(usr in form1.inscritos){
        println("Nome: ${usr.nome} , matricula: ${usr.matricula} ")
    }

    println()

    println(form2.nome)
    for( ctd in form2.conteudos ) println("conteudo ${ctd.nome}, duracao: ${ctd.duracao}")

    for(usr in form2.inscritos){
        println("Nome: ${usr.nome} , matricula: ${usr.matricula} ")
    }
}
