public class Level21 {


    private static Integer size = 8;
    private static Integer minDepth;
    private static Integer[] minDepthOfField = new Integer[size*size];   // minimal depth of every field ever achieved

    /** Solution Level 2.1 - Don't Get Volunteered! */
    public static int solution(int src, int dest) {

        int depth = 0;

        atPosition(src, dest, depth);

        if(minDepth != null){
            return minDepth;
        }
        else{
            return 0;
        }

    }

    public static int atPosition(int src, int dest, int depth){

        if(src == dest){
            return 0;
        }

        // convert position 0-63 (depending on size) into coordinates x, y
        int srcX = src%size;
        int srcY = (int)Math.floor(src/size);
        int destX = dest%size;
        int destY = (int)Math.floor(dest/size);

        int queue = 0;
        int posX;
        int posY;

        // if minimal depth of field is bigger than current depth of field, get new minDepthOfField
        if((minDepthOfField[src] == null)||(minDepthOfField[src] > depth)){
            minDepthOfField[src] = depth;
        }

        if(minDepthOfField[src] >= depth){
            for(int i = 0; i < 8; i++){
                // make a move
                int[] pos = move(srcX, srcY, queue);

                // if move was possible, assign values to variables
                if((pos[0]>=0)&&(pos[0]<size)&&(pos[1]>=0)&&(pos[1]<size)){
                    posX = pos[0];
                    posY = pos[1];
                    depth++;
                    // if pos == destination, check if depth < minDepth; else do atPosition
                    if((posX == destX)&&(posY == destY)){
                        checkMinDepth(depth);
                        return depth;
                    }
                    int newSrc = posY * size + posX;
                    atPosition(newSrc,dest,depth);
                    depth--;
                }

                queue++;

            }
        }


        return depth;
    }


    public static int checkMinDepth(int depth){

        if(minDepth == null){
            minDepth = depth;
        }
        if(depth < minDepth){
            minDepth = depth;
        }
        return minDepth;
    }


    /** does a move from src; which one is depending on value of queue; returns position after the move*/
    public static int[] move(int srcX, int srcY, int queue){

        int pos[] = new int[2]; // pos[0] = X value, pos[1] = Y value

        if(queue == 0){
            pos[0] = srcX + 1;
            pos[1] = srcY + 2;
        }
        if(queue == 1){
            pos[0] = srcX + 2;
            pos[1] = srcY + 1;
        }
        if(queue == 2){
            pos[0] = srcX + 2;
            pos[1] = srcY - 1;
        }
        if(queue == 3){
            pos[0] = srcX + 1;
            pos[1] = srcY - 2;
        }
        if(queue == 4){
            pos[0] = srcX - 1;
            pos[1] = srcY - 2;
        }
        if(queue == 5){
            pos[0] = srcX - 2;
            pos[1] = srcY - 1;
        }
        if(queue == 6){
            pos[0] = srcX - 2;
            pos[1] = srcY + 1;
        }
        if(queue == 7){
            pos[0] = srcX - 1;
            pos[1] = srcY + 2;
        }

        return pos;

    }


}
