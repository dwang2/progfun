object intsets {
	1+2
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	def union(other: IntSet): IntSet = other
	override def toString = "."
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