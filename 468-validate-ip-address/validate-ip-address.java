class Solution {
    public String validIPAddress(String s) {
        if (s.contains(".")) {
            return checkforipv4(s);
        } else if (s.contains(":")) {
            return checkforipv6(s);
        } else {
            return "Neither";
        }
    }

    public String checkforipv4(String s) {
        String[] ip4 = s.split("\\.", -1); // Use limit -1 to keep trailing empty strings if any
        if (ip4.length != 4) return "Neither";

        for (String num : ip4) {
            if (num.length() == 0 || (num.length() > 1 && num.charAt(0) == '0')) {
                return "Neither";  
            }
            try {
                int n = Integer.parseInt(num);
                if (n < 0 || n > 255) return "Neither";
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String checkforipv6(String s) {
        String[] ip6 = s.split(":", -1); // Use limit -1 to keep trailing empty strings if any
        if (ip6.length != 8) return "Neither";

        for (String num : ip6) {
            if (num.length() == 0 || num.length() > 4) return "Neither"; 

            for (char c : num.toCharArray()) {
                boolean isDigit = (c >= '0' && c <= '9');
                boolean isLowerAF = (c >= 'a' && c <= 'f');
                boolean isUpperAF = (c >= 'A' && c <= 'F');
                if (!(isDigit || isLowerAF || isUpperAF)) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
