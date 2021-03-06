import scala.quoted._, staging._

object Test:
  given Toolbox = Toolbox.make(getClass.getClassLoader)

  val f: Array[Int] => Int = run {
    val stagedSum: Expr[Array[Int] => Int] = '{ (arr: Array[Int]) => 6 }
    println(stagedSum.show)
    stagedSum
  }

  def main(args: Array[String]) = {
    f.apply(Array(1, 2, 3)) // Returns 6
 }
