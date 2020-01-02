class board implements global
{
    public block[][] blocks;
    private int st;

    public board() {
        this.st = 0;
        this.blocks = new block[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.blocks[i][j] = new block();
            }
        }
    }

    public void displayBoard() {
        System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");
        System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");
        System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");
    }

    public void displayPlayerSelectionBoard() {
        int i = 1;
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 3; ++k) {
                System.out.print((this.blocks[j][k].getst() == 0) ? Integer.valueOf(i) : this.blocks[j][k]);
                ++i;
                if (k != 2) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
    }

    public int getst() {
        return this.updatest();
    }

    public int updatest() {
        final int st = this.checkRow(0) + this.checkRow(1) + this.checkRow(2) + this.checkCol(0) + this.checkCol(1) + this.checkCol(2) + this.checkDiag();
        if (st != 0) {
            this.st = st;
        }
        else {
            this.st = this.checkDraw();
        }
        return this.st;
    }

    private int checkDraw() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.blocks[i][j].getst() == 0) {
                    return 0;
                }
            }
        }
        return 3;
    }

    private int checkRow(final int n) {
        if (this.blocks[n][0].getst() != 0 && this.blocks[n][0].getst() == this.blocks[n][1].getst() && this.blocks[n][1].getst() == this.blocks[n][2].getst()) {
            return this.blocks[n][0].getst();
        }
        return 0;
    }

    private int checkCol(final int n) {
        if (this.blocks[0][n].getst() != 0 && this.blocks[0][n].getst() == this.blocks[1][n].getst() && this.blocks[1][n].getst() == this.blocks[2][n].getst()) {
            return this.blocks[0][n].getst();
        }
        return 0;
    }

    private int checkDiag() {
        if (this.blocks[0][0].getst() != 0 && this.blocks[0][0].getst() == this.blocks[1][1].getst() && this.blocks[1][1].getst() == this.blocks[2][2].getst()) {
            return this.blocks[0][0].getst();
        }
        if (this.blocks[0][2].getst() != 0 && this.blocks[0][2].getst() == this.blocks[1][1].getst() && this.blocks[1][1].getst() == this.blocks[2][0].getst()) {
            return this.blocks[0][2].getst();
        }
        return 0;
    }

    public boolean putMove(final int move, final int st) {
        int move2 = 0;
        int move3 = 0;
        if (move < 1 || move > 9) {
            return false;
        }
        switch(move){
            case 1:
                move2 = 0;
                move3 = 0;
                break;
            
            case 2: 
                move2 = 0;
                move3 = 1;
                break;
        
            case 3:
                move2 = 0;
                move3 = 2;
                break;
        
            case 4:
                move2 = 1;
                move3 = 0;
                break;
            case 5:
                move2 = 1;
                move3 = 1;
                break;
            case 6:
                move2 = 1;
                move3 = 2;
                break;
        
            case 7:
                move2 = 2;
                move3 = 0;
                break;
            case 8:
                move2 = 2;
                move3 = 1;
                break;
            case 9:
                move2 = 2;
                move3 = 2;
                break;
        }
        if (this.blocks[move2][move3].getst() == 0) {
            this.blocks[move2][move3].setst(st);
            return true;
        }
        return false;
    }
}