
import sorting.{BubbleSort, CycleSort, QuickSort}
import org.scalatest.{BeforeAndAfter, FunSuite}
import scala.util.Random

 class SortTest extends FunSuite with BeforeAndAfter{

  var unsortedArray: Array[Int] = Array.empty[Int]
   var sortedArray: Array[Int] = Array.emptyIntArray

  before {
    val temp = List.fill(10000)(Random.nextInt(10))
    unsortedArray = temp.toArray
  }

  after{
    unsortedArray = Array.emptyIntArray
    sortedArray = Array.emptyIntArray
  }

  test("BubbleSort ascending order test") {
    sortedArray = BubbleSort.sort(unsortedArray)
    checkAscendingOrder(sortedArray)
  }

  test("BubbleSort descending order test") {
    sortedArray = BubbleSort.sort(unsortedArray)
    sortedArray = sortedArray.reverse
    checkDescendingOrder(sortedArray)
  }

  test("CycleSort ascending order test") {
    sortedArray = CycleSort.sort(unsortedArray)
    checkAscendingOrder(sortedArray)
  }

  test("CycleSort descending order test") {
    sortedArray = CycleSort.sort(unsortedArray)
    sortedArray = sortedArray.reverse
    checkDescendingOrder(sortedArray)
  }

  test("QuickSort ascending order test") {
    sortedArray = QuickSort.sort(unsortedArray)
    checkAscendingOrder(sortedArray)
  }

  test("QuickSort descending order test") {
    sortedArray = QuickSort.sort(unsortedArray)
    sortedArray = sortedArray.reverse
    checkDescendingOrder(sortedArray)
  }

  def checkAscendingOrder(array:Array[Int]): Unit ={
    var a = 0
    for (a <- (0 until array.length - 1)){
      assert(array(a) <= array(a + 1), "List not sorted properly. Number of iterations: " + a)
    }
  }
  def checkDescendingOrder(array:Array[Int]): Unit ={
    var a = 0
    for (a <- (0 until array.length - 1)){
      assert(array(a) >= array(a + 1), "list not sorted properly. Number of iterations: " + a)
    }
  }

}
