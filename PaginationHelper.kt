
fun main(args: Array<String>) {
    val array = Array(15,{i->"string #$i"});
    val paginationHelper = PaginationHelper(array,10)
    println(paginationHelper.length())
    println(paginationHelper.pagesCount())
    println(paginationHelper.itemsPerPage(1))
    println(paginationHelper.pageByItemId(9))
    paginationHelper.pagePrintln(0)
    println("__________________________________")
    paginationHelper.pagePrintln(1)
}

class PaginationHelper(array_:Array<String>,count_: Int) {
    private val array = array_
    private val count = count_

    fun length(): Int {
        return array.size
    }

    fun pagesCount():Int {
        if(array.size%count>0) return array.size/count+1
        else return array.size/count
    }

    fun itemsPerPage(num: Int): Int {
        if(this.pagesCount() > num+1) {
            return count
        } else if(this.pagesCount()== num+1) {
            return array.size%count
        } else {
            return 0 //возврат 0 при запросе номера страницы превышающей количество существующих
        }
    }

    fun pageByItemId(id: Int): Int {
        if(id<array.size) {
            if((id+1)%count>0) return (id+1)/count+1
            else return (id+1)/count
        } else {
            return -1 //возврат -1 при запросе id элемента превышающего размер списка
        }
    }

    fun pagePrintln(num: Int){
        var i = num*count
        while(i < num*count+count){
            if(i<array.size) println(array[i])
            i++
        }
    }
}