import java.util.Random;

public class Secret {

    private String text;
    private String keeper;

    private int keeperCount;
    private Secret previousSecret;

    public Secret(String keeper, String text) {
        this.keeper = keeper;
        this.text = text;
        this.keeperCount = 1;
    }

    public Secret(Secret previousSecret, String newKeeper) {
        this.previousSecret = previousSecret;
        this.keeper = newKeeper;
        this.keeperCount = previousSecret.keeperCount + 1;
        this.text = previousSecret.text;

        // Добавляем случайные символы
        int N = (int) Math.round(previousSecret.text.length() * 0.1);
        System.out.println(N);
        Random random = new Random();
        for (int i = 0; i < random.nextInt(N + 1); i++) {
            int position = random.nextInt(text.length());
            char randomChar = (char) (random.nextInt(26) + 'a');
            this.text = text.substring(0, position) + randomChar + text.substring(position);
        }

        System.out.println(previousSecret.keeper + " сказал что " + text);
    }

    public String toString() {
        return keeper + ": это секрет!";
    }

    public int getKeeperCount() {
        return keeperCount;
    }

    public int getRemainingHolders() {
        if (previousSecret == null) {
            return 0;
        } else {
            return previousSecret.getRemainingHolders() + 1;
        }
    }

    // Получение имени N-го хранителя секрета
    public String getKeeperName(int N) {
        if (N == 0) {
            return keeper;
        } else if (N > 0) {
            if (previousSecret != null) {
                return previousSecret.getKeeperName(N - 1);
            } else {
                return null;
            }
        } else {
            if (previousSecret != null) {
                return previousSecret.keeper;
            } else {
                return null;
            }
        }
    }

    // Получение разницы в количестве символов текста секрета с N-ым хранителем
    public int getDifferenceWithHolder(int N) {
        if (N == 0) {
            return 0;
        } else if (N > 0) {
            if (previousSecret != null) {
                return previousSecret.getDifferenceWithHolder(N - 1) + (text.length() - previousSecret.text.length());
            } else {
                return 0;
            }
        } else {
            if (previousSecret != null) {
                return text.length() - previousSecret.text.length();
            } else {
                return 0;
            }
        }
    }
}
