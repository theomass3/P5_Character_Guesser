public class Character{
    private boolean isAlive, isHuman, isDroid, hasForce, inANH, inESB, inROTJ, isMale, speaksEnglish, isGoodGuy;

    public Character(boolean isAlive, boolean isHuman, boolean isDroid, boolean hasForce, boolean inANH, boolean inESB, boolean inROTJ, boolean isMale, boolean speaksEnglish, boolean isGoodGuy) {
        this.isAlive = isAlive;
        this.isHuman = isHuman;
        this.isDroid = isDroid;
        this.hasForce = hasForce;
        this.inANH = inANH;
        this.inESB = inESB;
        this.inROTJ = inROTJ;
        this.isMale = isMale;
        this.speaksEnglish = speaksEnglish;
        this.isGoodGuy = isGoodGuy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public boolean isDroid() {
        return isDroid;
    }

    public boolean isHasForce() {
        return hasForce;
    }

    public boolean isInANH() {
        return inANH;
    }

    public boolean isInESB() {
        return inESB;
    }

    public boolean isInROTJ() {
        return inROTJ;
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isSpeaksEnglish() {
        return speaksEnglish;
    }

    public boolean isGoodGuy() {
        return isGoodGuy;
    }
}

