package expr.boolean

import sexpr._

/**
 * This object defines types for creating and evaluating boolean
 * expressions. In particular, it should define the six different
 * boolean expressions that are based on those defined by the
 * boolean sexpr language - except, here they are actual case
 * classes rather than s-expression data types.
 *
 * You must define six case classes that extend Expr (see below):
 *
 * (1) True
 * (2) False
 * (3) Not(e)
 * (4) And(e1,e2)
 * (5) Or(e1,e2)
 * (6) If(c,e1,e2)
 *
 * Note, that case classes are automatically provided a toString
 * method that will resemble how they were constructed. For example,
 *
 * scala> True
 * "True"
 * scala> Not(True)
 * "Not(True)"
 *
 * We will use these strings to test your code - so you must ensure
 * that your case classes exactly resemble the 1-6 definitions above.
 *
 * You must also implement the `parse` and `eval` methods defined
 * below. These methods will parse an SExpr type into a Expr type and
 * evaluate an Expr to an Expr respectively.
 */
object BooleanExpr extends BooleanLanguage {
  sealed trait Expr

  // TODO: Define your case classes here.
  case class True() extends Expr
  case class False() extends Expr
  case class Not(s: SExpr) extends Expr
  case class And(e1: SExpr, e2: SExpr) extends Expr
  case class Or(e1: SExpr, e2: SExpr) extends Expr
  case class If(c: SExpr, e1: SExpr, e2: SExpr) extends Expr

  // TODO: implement the parse method.
  // The parse method translates an SExpr type into the Expr types
  // that you defined above. This allows us to define boolean
  // expressions using sexpr form - which decouples your
  // implementation from definitions of boolean expression.
  //
  // Example:
  //
  // scala> parse(&&(T,F))
  // And(True,False)
  //
  // You will need to pay attention to the structure of the sexprs
  // for proper translation.
  //
  // You must you pattern matching and recursion in your
  // implementation.
  //
  // If you are given an improperly formatted boolean sexpr you must
  // throw an IllegalArgumentException.
  def parse(ss: SExpr): Expr = ???

  // TODO: implement the eval method.
  //
  // The eval function "evaluates" a boolean expression. Your function
  // must implement the following rules:
  //
  // (1)  true                  => true
  // (2)  false                 => false
  // (3)  !true                 => false
  // (4)  !false                => true
  // (5)  true && e             => e
  // (6)  false && e            => false
  // (7)  true || e             => true
  // (8)  false || e            => e
  // (9)  if(true) e1 else e2   => e1
  // (10) if(false) e1 else e2  => e2
  //
  // Here are some things you need to consider:
  //
  // (1) When you see an expression e on the right-hand side of a
  //     rule you will need to recursively evaluate e.
  //
  // (2) Although we have given you most rules above, there are other
  //     fules that you will need to implement for proper evaluation.
  //     That is, you must adhere to (4) below for your implementation
  //     to be correct.
  //
  // (3) You need to consider commutativity of operators.
  //
  // (4) Your eval function will always evaluate the given expression
  //     to either the true or false boolean expression.
  //
  def eval(e: Expr): Expr = ???
}
