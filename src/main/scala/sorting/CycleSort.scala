package sorting

import scala.util.control.Breaks._

object CycleSort extends Sort {
  override def sort(unsorted: Array[Int]): Array[Int] = {
    val tempArray: Array[Int] = unsorted
    var writes: Int = 0
    for (cycleStart: Int <- 0 until tempArray.length - 1) {
      breakable {
        var value: Int = tempArray(cycleStart)
        var pos: Int = cycleStart
        for (i <- cycleStart + 1 until tempArray.length) {
          if (tempArray(i) < value) {
            pos += 1
          }
        }
        if (pos == cycleStart) break
        while (value == tempArray(pos)) {
          pos += 1
        }
        val tmp: Int = tempArray(pos)
        tempArray(pos) = value
        value = tmp
        writes += 1

        while (pos != cycleStart) {
          pos = cycleStart
          for (i <- cycleStart + 1 until tempArray.length) {
            if (tempArray(i) < value) pos += 1
          }
          while (value == tempArray(pos)) {
            pos += 1
          }
          val tmp: Int = tempArray(pos)
          tempArray(pos) = value
          value = tmp
          writes += 1
        }
      }
    }
    println("Number of writes: " + writes)
    return tempArray
  }
}
