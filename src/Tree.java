public class Tree {
    private Node root;

    public Node find(Integer data) {
        Node aux = root;

        while(aux.getData() != data) {
            if(aux.getData() > data) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }

        if(aux == null) return null;

        return aux;
    }

    public void insert(Integer data) {
        Node node = new Node(data);

        if(root == null) {
            root = node;
        } else {
            boolean inserted = false;
            Node aux = root;

            while(!inserted) {
                if(node.getData() <= aux.getData()) {
                    if(aux.getLeft() == null) {
                        aux.setLeft(node);
                        inserted = true;
                    } else {
                        aux = aux.getRight();
                    }
                } else {
                    if(aux.getRight() == null) {
                        aux.setRight(node);
                        inserted = true;
                    } else {
                        aux = aux.getLeft();
                    }
                }
            }
        }
    }

    public Node delete(Integer data) {
        Node aux = root;
        Node dad = null;

        if(root == null) return null;

        while(aux.getData() != data) {
            if(aux.getData() < data) {
                dad = aux;
                aux = aux.getLeft();
            } else {
                dad = aux;
                aux = aux.getRight();
            }

            if(aux == null) return null;
        }

        Node deleted = aux;
        Node successor = aux.getRight();

        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }


//        if(dad != null) {
//            Node dadAux = dad;
//            Node successor = null;
//
//            if(dad.getData() > data) {
//                dadAux = dad.getLeft();
//            } else {
//                dadAux = dad.getRight();
//            }
//
//            while (successor == null) {
//                dadAux = dadAux.getLeft();
//
//                if(dadAux.getLeft() == null) successor = dadAux;
//            }
//
//            aux = successor;
//        }

        return deleted;
    }
}
