// Random Replacement
import scala.util.Random.nextInt

val range = 10000
val maxSize = 10
var cache: Vector[Int] = Vector()

def test(i: Int): Boolean = {
  if (cache.exists(_ == i)) {
    return true
  } else {
    if (cache.lengthIs < 10) {
      cache = cache :+ i
      return false
    } else {
      val r = nextInt(maxSize)
      cache.updated(r, i)
      return false
    }
  }
}

val trial = 100000000
var hit = 0.0
var miss = 0.0
(1 to trial).foreach { _ =>
  val random = nextInt(range)
  if (test(random)) {
    hit = hit + 1
  } else {
    miss = miss + 1
  }
}

println(hit, miss)
println(s"${hit / trial * 100}%")
println(s"${miss / trial * 100}%")

