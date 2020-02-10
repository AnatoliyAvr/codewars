package mutualRecursion

fun f(n: Int): Int {
  if (n == 0)
    return 1
  return n - m(f(n - 1))
}

fun m(n: Int): Int {
  if (n == 0)
    return 0
  return n - f(m(n - 1))
}

/*
Mutual Recursion allows us to take the fun of regular recursion (where a function calls itself until a
terminating condition) and apply it to multiple functions calling each other!

Let's use the Hofstadter Female and Male sequences to demonstrate this technique.
You'll want to create two functions F and M such that the following equations are true:
*/