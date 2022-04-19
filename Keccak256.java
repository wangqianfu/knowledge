import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;

/**
 * @Author: wxm
 * @Date: 2022/4/18 17:29
 */
public class Keccak256 {

    public static void main(String[] args) {
        String str = "deposit(address)";
        String methodId = getMethodId(str);
        System.out.println("methodId:" + methodId);
    }

    /**
     * 根据函数获取方法id
     *
     * @param function 函数
     * @return
     */
    public static String getMethodId(String function) {
        try {
            Keccak.Digest256 digest = new Keccak.Digest256();
            byte[] digest1 = digest.digest(function.getBytes());
            String hash = Hex.toHexString(digest1);
            return "0x" + hash.substring(0, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
