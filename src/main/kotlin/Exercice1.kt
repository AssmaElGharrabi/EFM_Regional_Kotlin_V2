fun String.estVideOuBlanche(){
    if (isEmpty()){
        println("Is empty")
    }
    if(isBlank()) {
        println("Is blank")
    }
}

fun String.sigle(): String {
    val mots= this.split(" ").filter { it.isNotBlank() }
    val sigle = StringBuilder()
    for (mot in mots) {
        sigle.append(mot[0].toUpperCase())
    }
    return sigle.toString()
}