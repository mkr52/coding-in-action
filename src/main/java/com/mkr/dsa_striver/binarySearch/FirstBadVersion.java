package com.mkr.dsa_striver.binarySearch;

class BadVersion {
    private int badVersion;

    public BadVersion(int v) {
        this.badVersion = v;
    }

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

public class FirstBadVersion extends BadVersion {
    public FirstBadVersion(int v) {
        super(v);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Driver code
    public static void main(String[] args) {
        int[] versions = {6, 8, 9, 11, 8};
        int[] badVersions = {3, 5, 1, 11, 4};

        for (int i = 0; i < versions.length; i++) {
            FirstBadVersion solution = new FirstBadVersion(badVersions[i]);
            System.out.println((i + 1) + ".\tNumber of versions: " + versions[i]);
            System.out.println("\n\tFirst bad version: " + solution.firstBadVersion(versions[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
