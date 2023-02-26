class Dictionnaire {

    var listEntree : ArrayList<Entree> = arrayListOf()

    fun nombreEntrees() : Int{
        return listEntree.size
    }

    fun ajouter(e: Entree){
        if (listEntree.contains(e)){
            throw Exception("appartient déjà au dictionnaire")
        }else listEntree.add(e)
    }

    fun supprimer(e: Entree) : Boolean {
        if(listEntree.contains(e)) {
            listEntree.remove(e)
            return true
        }else {
            throw Exception("n’existe pas")
            return false
        }
    }

    fun supprimer(motFrancais: String) : Boolean{
        var etat : Boolean = false
        for (e in listEntree){
            if (e.motFrancais == motFrancais){
                listEntree.remove(e)
                etat=true
            }else {
                throw Exception("n’existe pas")
                etat = false
            }
        }
        return etat
    }

    fun anFr(motAnglais : String) : ArrayList<String> {
        val motFr = arrayListOf<String>()
        for (e in listEntree) {
            if (e.motAnglais == motAnglais) {
                motFr.add(e.motFrancais)
            }
        }
        return motFr
    }

    fun motsAnglais(): Set<String> {
        return listEntree.map { it.motAnglais }.toSet()
    }

    fun dictionnaireAnFr(): Map<String, ArrayList<String>>{
        val dict = HashMap<String, ArrayList<String>>()
        for (e in listEntree) {
            val motFr = dict.getOrDefault(e.motAnglais, ArrayList())
            motFr.add(e.motFrancais)
            dict[e.motAnglais] = motFr
        }
        return dict
    }

    override fun toString():String{
        val str = StringBuilder()
        for (e in listEntree) {
            str.append(e.toString())
            str.append("\n")
        }
        return str.toString()
    }
}