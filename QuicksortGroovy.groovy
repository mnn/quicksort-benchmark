def swap(a, i, j) {
    temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

def sort1(a, l, r) {
    m = a[((l + r) / 2).intValue()]
    i = l
    j = r
    while (i <= j) {
        while (a[i] < m) i++
        while (a[j] > m) j--
        if (i <= j) {
            swap(a, i, j)
            i++
            j--
        }
    }
    if (l < j) sort1(a, l, j)
    if (r > i) sort1(a, i, r)
}

def quicksort(a) {
    sort1(a, 0, a.length - 1)
}

def calcBest(a) {
    best = Long.MAX_VALUE
    for (i in 0..10) {
        t1 = System.currentTimeMillis()
        quicksort(a)
        t2 = System.currentTimeMillis()
        best = Math.min(t2 - t1, best)
    }
    best
}

a = new int[2000000*1]
a.eachWithIndex { x, i ->
    a[i] = i * 3 / 2 + 1
    if (i % 3 == 0) a[i] = -a[i]
}

println calcBest(a)
