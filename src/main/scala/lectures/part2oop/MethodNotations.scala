package lectures.part2oop
import scala.language.postfixOps
object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(secondName: String): Person = new Person(s"$name ($secondName)", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)

    def isAlive: Boolean = true
    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala = this learns "Scala"

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(num: Int) = s"$name watched $favoriteMovie $num times"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inceptions"))
  println(mary likes "Inceptions") //equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(2.+(1))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) //equivalent

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)

    2.  Add an age to the person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age increment

    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.

    4.  Overload the apply method
        marry.apply(2) => "Mary watched Inceptions 2 times"
   */

  println((mary + "the rockstar")())
  println((+ mary).age)

  println(mary learnsScala)
  println(mary(3))
}
