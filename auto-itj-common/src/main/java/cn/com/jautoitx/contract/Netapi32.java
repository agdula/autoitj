package cn.com.jautoitx.contract;

/**
 * @author: Andrzej Gdula
 * @created: 09/30/2015 20:25
 * @version: 1.0
 */
public interface Netapi32 {
    /**
     * Deletes a share name from a server's list of shared resources,
     * disconnecting all connections to the shared resource.
     *
     * @param servername
     * @param netname
     * @return
     */
    int netShareDel(String servername, String netname);

    /**
     * Shares a server resource.
     *
     * @param servername
     * @param netname
     * @param remark
     * @param permissions
     * @param path
     * @param passwd
     * @return
     */
    int netShareAdd(String servername, String netname,
                                  String remark, int permissions, String path, String passwd);
}
