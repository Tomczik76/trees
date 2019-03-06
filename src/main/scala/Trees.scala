object Trees {



  case class Node(v: Int, l:Option[Node] = None, r:Option[Node] = None) {
    def add(i:Int): Node = {
      def recur(node:Node): Node = node match {
        case n @ Node(value, None, _) if i < value => n.copy(l = Some(Node(i, None, None)))
        case n @ Node(value, _, None) if i > value => n.copy(r = Some(Node(i, None, None)))
        case n @ Node(value, Some(n2), _) if i < value => n.copy(l = Some(recur(n2)))
        case n @ Node(value, _, Some(n2)) if i > value => n.copy(r = Some(recur(n2)))
      }
      recur(this)
    }
  }


  def toTree(array: Array[Int]): Node = {
    array.tail.foldLeft(Node(array.head))((tree, i) => tree.add(i))
  }

  def main(args: Array[String]): Unit = {
    val data = Array(200, 100, 50, 150, 400, 800, 700, 600, 1000)
    println(toTree(data))
  }
}
