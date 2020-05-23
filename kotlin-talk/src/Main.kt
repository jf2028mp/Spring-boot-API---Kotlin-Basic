import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    //with()
    //print(Database.init())
    // print(sum(50,50))
    //lettersRange()
    //also()
    //val person = Person("jeffry","martinez")
    //print(person.addAge())
    //print(lisWithNullsExample())
    //print(lettersRange())
    //f()
    //palindrome("oro")
    //notNullWithLet()
    //zip()
    print(Date().dateFormat())




}



fun lisWithNullsExample(){
    val lisWithNulls:List<Int?> = arrayListOf(1,2,3,4,null,4,5,6,null)
    for(item in lisWithNulls){

    }
}


object Database{
    fun init():String = "init"
}




private fun range() {
}

private fun f(){
    val array = arrayOf(1,2,3,4,5,6)
    for (i in 1..21 step 10) print(i)

    print(array.reverse().toString())

    val st = setOf(1,2,3,4,5,6)
    st.stream().filter { it >0 }.map {
        print(it)
    }
}
private fun palindrome(word:String){
    val palindrome = word.split("")
        .reversed()
        .joinToString(prefix = "",postfix = "", separator = "")
    if(palindrome == word){
        print("Es un palindrome")
    }else{
        print("No es palindrome")

    }


}
private fun let(){
    val array = arrayOf(5,4,5,6,7,8,9,null,10,null)
    array.distinct().forEach { n -> n?.let {

    }}

}
private fun apply(){
    val person = Person()


}

private fun inline(x:Int,y:Int) = x+y

private fun whenCase(){
    val name = ""
    val array = arrayOf(1,2,3,4,5,6,7)
    array.forEach { i -> print(i) }
}
private fun Date.dateFormat():String{
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    return formatter.format(this)
}







