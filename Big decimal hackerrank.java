Arrays.sort(s, 0, n, new Comparator<String>() {
@Override
        public int compare(String a, String b) {
            BigDecimal b1 = new BigDecimal(a);
               BigDecimal b2 = new BigDecimal(b);
               return b2.compareTo(b1);
            }
        });     



