// FIFO cache algorithm
import scala.util.Random.nextInt

val x = (1 to 10000).toArray
val y: Array[Int] = new Array(10)
var yCursor = 0


def get(i: Int): Boolean = {
  if (y.exists(_ == i)) {
    return true
  } else {
    y(yCursor) = i
    yCursor = (yCursor + 1) % y.length
    return false
  }
}

var hit = 0.0
var miss = 0.0
val trial = 100000000
(1 to trial).foreach { _ =>
  if (get(nextInt(10000))) {
    hit = hit + 1
  } else {
    miss = miss + 1
  }
}

println(hit, miss)
println(s"${hit / trial * 100}%")
println(s"${miss / trial * 100}%")
