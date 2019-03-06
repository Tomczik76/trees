import Trees.Node
import org.scalatest.FunSpec

class TreeSpec extends FunSpec {

  describe("Add operation") {
    it("can add to left") {
      assert(Node(2, None, None).add(1) == Node(2, Some(Node(1))))
    }

    it("can add to left 2") {
      assert(Node(2, None, Some(Node(3))).add(1) == Node(2, Some(Node(1)), Some(Node(3))))
    }

    it("can add to right") {
      assert(Node(2, None, None).add(3) == Node(2, None, Some(Node(3))))
    }

    it("can add to right 2") {
      assert(Node(2, Some(Node(1)), None).add(3) == Node(2, Some(Node(1)), Some(Node(3))))
    }

    it("can add to left 3") {
      assert(Node(3, Some(Node(2)), None).add(1) == Node(3, Some(Node(2, Some(Node(1)))), None))
    }

    it("can add to right 3") {
      assert(Node(2, Some(Node(1)), Some(Node(3))).add(4) == Node(2, Some(Node(1)), Some(Node(3, None, Some(Node(4))))))
    }

  }


  describe("toTree") {
    it("works") {
      val input = Array(200, 100, 50, 150, 400, 800, 700, 600, 1000)
      val result =
        Node(200,
          Some(Node(100,
            Some(Node(50,
              None,
              None)),
            Some(Node(150,
              None,
              None)))),
          Some(Node(400,
            None,
            Some(Node(800,
              Some(Node(700,
                Some(Node(600,
                  None,
                  None)),
                None)),
              Some(Node(1000,
                None,
                None)))))))
      assert(Trees.toTree(input) == result)
    }
  }
}
