
fun main(args: Array<String>) {
    val array = Array(15,{"string #$it"});
    val paginationHelper = PaginationHelper(array,10)
    println(paginationHelper.length())
    println(paginationHelper.pagesCount())
    println(paginationHelper.getItemsPerPage(0))
    println(paginationHelper.getPageByElementIndex(16))
}

class PaginationHelper(private val array:Array<String>,private val count: Int) {
    fun length() = array.size

    fun pagesCount() = if(array.size%count>0) array.size/count+1 else array.size/count

    fun getItemsPerPage(pageIndex: Int) =
            when (pageIndex){
                in 0 until pagesCount()-1 -> count
                pagesCount()-1 -> array.size - count*(pagesCount()-1)
                else -> 0
            }

    fun getPageByElementIndex(elementIndex: Int) = if(elementIndex in 0..array.size) elementIndex/count else -1

}