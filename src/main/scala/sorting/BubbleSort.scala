package sorting

object BubbleSort extends Sort {
  override def sort(unsorted: Array[Int]): Array[Int] ={
   var tempArray:Array[Int] = unsorted
    for (a <- tempArray.reverse){
      for(i <- (0 to tempArray.length - 2)){
        val k = tempArray(i)
        val l = tempArray(i + 1)
        if (k > l) tempArray = swap(tempArray, i, i + 1)
      }
    }
    return tempArray
}
    private def swap (givenArray: Array[Int], x: Int, y: Int): Array[Int] ={
        val temp = givenArray(x)
        givenArray(x) = givenArray(y)
        givenArray(y) = temp
        return givenArray
    }

}

