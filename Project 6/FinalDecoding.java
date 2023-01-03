/* The final decoding class makes it possible to use all the ciphers stemming from the BaseCipher class and uses those ciphers to decode a message.*/
public class FinalDecoding {
    public static void main(String[] args) {
        String[] encoded = {
                "jjdtdbsxy zjyjbw.kwzfjd  hzqdma  qsy tn!dzxj nx  fjy hzw m wq zwsq ywin dlwl,yj yxfxrq fywt tps yz tr wus-fp msnbq fjahtd fm fm fawgi fy twq m ti tysyq,nfyfq fjfuf ti y t j,kwynma tfvnjyjlnqhwjydxtj sr ffj msn'  nujryj kmtnln uy dutfjys.yj  nqma nyw!m fm fm!",
                "ufjtjt m qsn ji.yjlnqn ywin dlwl,gyna j s kn' zwx htws tr stryt dlwl f  rq zswgqy y31f aw tss.yn tqsyg tjxrq.mx s kyjuf xwfd m wq xxtj sr ffj z 'jrytjt yxlfi.fhinly dnkwfnsr ffjmxfxfqaqjfnndf :2rjjdrwnl mxhzi' jrw nuj",
                "ufjtjbs k nmz  nh.ufjytn ji tglsmx s jytkbytyfmym mx b xwfdy jn.",
                "ufjytn was tjyr txrs msjuhj.yjutfjys jqdijsybs tbw nmyn wq.yn nqyp tjyr.kwzfjdyjsnmtmt wj tx' sbnrmw j.x tlf mdisypt,na t njmx b xutnlrw njhsznlyf cjyi m wus-fpwfq tx' fyy tpby mxlnq mxbq fjxr nj tysyq m jlgwtitiwijsypt ' jjdy tqs xyj t' sb 'jlyyr."

        };
        WordReplacementCipher wR = new WordReplacementCipher("world","neighborhood");
        WordReplacementCipher wR1 = new WordReplacementCipher("enigma device","grill");
        WordReplacementCipher wR2 = new WordReplacementCipher("fort knox","my garage");
        WordReplacementCipher wR3 = new WordReplacementCipher("omni-matrix","propane-tank");
        EvenOddCipher eO = new EvenOddCipher();
        CaesarCipher cC = new CaesarCipher(5);

        BaseCipher[] cipherChain = {wR,wR1,wR2,wR3,eO,cC};
        SuperCipher superCipher = new SuperCipher(cipherChain);
        String[] decoded = EncryptUtils.decryptMany(superCipher, encoded);
        for (int i = 0; i < decoded.length; i++) {
            System.out.println(decoded[i]);
        }
    }
}
