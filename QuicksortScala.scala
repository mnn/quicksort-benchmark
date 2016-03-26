object QuicksortScala {

  def swap(xs: Array[Int], i: Int, j: Int) {
    val t = xs(i)
    xs(i) = xs(j)
    xs(j) = t
  }

  def sort1(xs: Array[Int], l: Int, r: Int) {
    val pivot = xs((l + r) / 2)
    var i = l
    var j = r
    while (i <= j) {
      while (xs(i) < pivot) i += 1
      while (xs(j) > pivot) j -= 1
      if (i <= j) {
        swap(xs, i, j)
        i += 1
        j -= 1
      }
    }
    if (l < j) sort1(xs, l, j)
    if (r > i) sort1(xs, i, r)
  }

  def quicksort(xs: Array[Int]) {
    sort1(xs, 0, xs.length - 1)
  }

  def calcBest(a: Array[Int]): Long = {
    var best = Long.MaxValue
    for (i <- 0 until 10) {
      val t1 = System.currentTimeMillis
      quicksort(a)
      val t2 = System.currentTimeMillis
      best = Math.min(t2 - t1, best)
    }
    best
  }

  def main(args: Array[String]) {
    val a: Array[Int] = new Array[Int](2000000*1)
    for (i <- a.indices) {
      a(i) = i * 3 / 2 + 1
      if (i % 3 == 0) a(i) = -a(i)
    }

    println(calcBest(a))
  }
}
