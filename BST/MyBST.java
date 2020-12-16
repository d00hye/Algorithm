package week4;

// 제가 수업에서 배운 것을 바탕으로 다시 구현해본 BST입니다.
// 조금 더 간략하게 구현해보려고 하였고 다른 값을 구하는 함수도 만들어봤습니다

class BinarySearchTree2 {
	// Node는 left와 right 값을 갖는다
	class Node{
		
		int data;
		Node left, right;
	
	public Node(int data) {
		this.data=data;
	}}
	// Tree에 root설정
	Node root;
	public Node search(Node root, int key) {
		// leaf Node를 찾거나 찾는 값을 찾았을 경우
		if(root ==null || root.data==key ) return root;
		// 못 찾았을 때Node의 값과 찾는 값을 비교
		if(root.data>key) return search(root.left, key);
		return search(root.right, key);
	}
	
	public void insert(int data) {
		// 삽입할 값 받은후 재귀함수 호출, root에 저장
		root = insert(root, data);
	}
	
	private Node insert(Node root, int data) {
		if (root ==null) {
			// 값이 null 일 시 새로 생성
			root = new Node(data);
			return root;
		}
		if(data<root.data) 
			root.left= insert(root.left, data);
		else if(data>root.data)
			root.right= insert(root.right, data);
		return root;
	}
	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) {
		// 값이 null일 시 그대로 반환
		if(root==null) return root;
		// 삭제할 데이터의 위치 파악
		if(data<root.data)
			root.left = delete(root.left, data);
		else if(data>root.data)
			root.right = delete(root.right, data);
		// 삭제할 데이터를 찾았을 경우
		else {
			// no child - 링크 끊기
			if(root.left==null && root.right== null) return null;
			// one child - 반대 반환
			else if (root.left==null) return root.right;
			else if (root.right==null) return root.left;
			// 2 children
				// 큰 값 중 최소 값을 찾고 그 값으로 대체 
			root.data = successor(root.right);
				// 그 root가 된 값은 지워줘야 한다.
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	private int successor(Node root) {
		int min = root.data;
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	
	public void inorder() {
		inorder(root);
		System.out.println("");
	}

	private void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
			}
	}
	
	public int cl() {
		// 리프노드 갯수
		return countLeaves(root);
	}
	int countLeaves(Node p) {
		if (p == null) {
			return 0;
		}
		if (p.left == null && p.right == null) {
			return 1;
		}
		return countLeaves(p.left) + countLeaves(p.right);
	}
////////////////////////////////////////////////////////////////////////

	public int sumleaves() {
		// 배열 만들어서 더하기로 리프 노드들의 합을 구한다
		return ipl(root, 0, 0);
	}
	int ipl(Node p, int countSum, int tot) {
		countSum++;
		if (p.left != null) {
			return ipl(p.left, countSum, tot);
		} if (p.right != null) {
			return ipl(p.right, countSum, tot);
		} else if (p.left == null && p.right == null) {
			int k=cl();
			int e[] = new int[k];
			for (int i = 0; i < e.length; i++) {
				e[i] = countSum;
				tot += e[i];
			}
		}
		return tot;

	}
	
	public int IPL() {
	      return ipl(root, 0);
	   }

	  int ipl(Node p, int level) {
	      if (p==null)
	         return 0;
	      else
	         return level + ipl(p.left, level+1) + ipl(p.right, level+1);
	   }
	
}
	public class MyBST{
		public static void main(String[] args) {
			BinarySearchTree2 tree = new BinarySearchTree2();

			/*
			 * 			  4
			 * 			/   \
			 * 		   2	 6
			 * 		 /	 \	/  \
			 * 		1	 3 5	7
			 */
			
			tree.insert(4);
			tree.insert(2);
			tree.insert(1);
			tree.insert(3);
			tree.insert(6);
			tree.insert(5);
			tree.insert(7);
			tree.inorder();

			System.out.println("IPL : " + tree.IPL());
			System.out.println("cl : " + tree.cl());
			System.out.println("sumleaves : " + tree.sumleaves());
			
			tree.delete(7);
			tree.inorder();
			
			tree.delete(2);
			tree.inorder();
			
			System.out.println("IPL : " + tree.IPL());
			System.out.println("cl : " + tree.cl());
			System.out.println("sumleaves : " + tree.sumleaves());
			
			
			
			
		}
	}


