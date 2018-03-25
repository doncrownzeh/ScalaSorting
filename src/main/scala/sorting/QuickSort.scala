package sorting

object QuickSort extends Sort {

   def partition(array: Array[Int], left: Int, right: Int): Int ={
    val pivot:Int = array(right)
    var i:Int = left
    for (j <- left until right){
      if (array(j) <= pivot){
        val temp:Int = array(j)
        array(j) = array(i)
        array(i) = temp
        i += 1
      }
    }
      val temp = array(i)
     array(i) = array(right)
     array(right) = temp
      return i
  }

  private def quickSort(array: Array[Int], low: Int, high: Int): Array[Int] = {

    if (low < high){
        val p: Int = partition(array, low, high)
      quickSort(array, 0, p - 1)
      quickSort(array, p + 1, high)
    }
    return array
  }
  override def sort(unsorted: Array[Int]): Array[Int] = {
    var tempArray:Array[Int] = unsorted
  return quickSort(tempArray, 0, unsorted.length - 1)
  }
}
