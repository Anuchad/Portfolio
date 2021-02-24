package com.example.quiz

class Itemlist {

    var section:Int ? = 0
    var question:String ? = null
    var article1:String ? = null
    var article2:String ? = null
    var article3:String ? = null
    var article4:String ? = null


    constructor(section: Int?, question: String?,article1: String?, article2: String?, article3: String?, article4: String?) {
        this.section = section
        this.question = question
        this.article1 = article1
        this.article2 = article2
        this.article3 = article3
        this.article4 = article4
    }
}