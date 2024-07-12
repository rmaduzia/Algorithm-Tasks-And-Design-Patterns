package algorithms.codewars.SixKyu;

public class FractionsClass {

    class Fraction implements Comparable<Fraction>
    {
        private final long top;
        private final long bottom;

        public Fraction(long numerator, long denominator) {
            top = numerator;
            bottom = denominator;
        }

        @Override
        public int hashCode() { return 17 * Long.hashCode(top) + Long.hashCode(bottom); }
        @Override
        public boolean equals(Object o) { return compareTo((Fraction)o) == 0; }
        @Override
        public int compareTo(Fraction f2){ return Long.compare(top * f2.bottom, f2.top * bottom); }

        @Override
        public String toString() {
            return top + "/" + bottom;
        }

        public long getTop() {
            return top;
        }

        public long getBottom() {
            return bottom;
        }

        public Fraction add(Fraction f2) {
            long newNumerator=0;
            long newDenominator = 0;

            if (getBottom() == f2.getBottom()) {
                newNumerator = getTop() + f2.getTop();
            } else {
                newNumerator = getTop() * f2.getBottom() + f2.getTop() * getBottom();
            }

            if (getBottom() == f2.getBottom()) {
                newDenominator = getBottom();
            } else {
                newDenominator = getBottom() * f2.getBottom();
            }

            long frac = getFrac(newNumerator, newDenominator);
            newNumerator /= frac;
            newDenominator /= frac;

            return new Fraction(newNumerator, newDenominator);
        }

        public long getFrac(long a, long b) {
            if(b==0)
                return a;
            return getFrac(b, a % b);
        }
    }
}
