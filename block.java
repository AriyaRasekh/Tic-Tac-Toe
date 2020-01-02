class block implements global
{
    private int st;

    public block() {
        this.st = 0;
    }

    public boolean setst(final int st) {
        if (this.isValidst(st)) {
            this.st = st;
            return true;
        }
        return false;
    }

    public int getst() {
        return this.st;
    }

    public boolean isValidst(final int n) {
        return n == 2 || n == 1;
    }

    @Override
    public String toString() {
        if (this.st == 0) {
            return " ";
        }
        if (this.st == 1) {
            return "x";
        }
        return "o";
    }
}