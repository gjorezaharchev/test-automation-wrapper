package com.taw.common.drivers;

/**
 * @author gjore.zaharchev
 */
class OSValidator {

    //private static String OS = System.getProperty("os.name").toLowerCase();

	/*public static void main(String[] args) {

		System.out.println(OS);

		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
	}*/

    public static boolean isWindows(final String OS) {
        return (OS.contains("win"));
    }

    public static boolean isMac(final String OS) {
        return (OS.contains("mac"));
    }

    public static boolean isUnix(final String OS) {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris(final String OS) {
        return (OS.contains("sunos"));
    }

}