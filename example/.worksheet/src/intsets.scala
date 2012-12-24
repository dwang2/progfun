object intsets {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(21); val res$0 = 
	1+2;System.out.println("""res0: Int(3) = """ + $show(res$0))}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {;$skip(190); 
	def contains(x: Int): Boolean = false;System.out.println("""contains: (x: Int)Boolean""");$skip(58); 
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty);System.out.println("""incl: (x: Int)IntSet""");$skip(42); 
	def union(other: IntSet): IntSet = other;System.out.println("""union: (other: IntSet)IntSet""");$skip(29); 
	override def toString = ".";System.out.println("""toString: ()java.lang.String""")
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	override def toString = "{" + left + elem + right + "}"

	def union(other: IntSet): IntSet =
		other.incl(elem).union(left).union(right)

	def contains(x: Int): Boolean =
		if(x<elem) return left.contains(x)
		else if(x>elem) return right.contains(x)
		else true
		
	def incl(x: Int): IntSet =
		if(x<elem) return new NonEmpty(elem, left incl x, right)
		else if(x>elem) return new NonEmpty(elem, left, 	right incl x)
		else this
}