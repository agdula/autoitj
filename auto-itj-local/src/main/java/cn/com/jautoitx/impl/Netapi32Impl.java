package cn.com.jautoitx.impl;

import cn.com.jautoitx.contract.Netapi32;
import cn.com.jautoitx.domain.ShareInfo2;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.DsGetDC;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.NTSecApi;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APIOptions;

/**
 * @author: Andrzej Gdula
 * @created: 09/30/2015 20:29
 * @version: 1.0
 */
public class Netapi32Impl implements Netapi32 {

    static protected Netapi32Ext INSTANCE = (Netapi32Ext) Native.loadLibrary("Netapi32",
            Netapi32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

    protected interface Netapi32Ext extends com.sun.jna.platform.win32.Netapi32 {

        /**
         * Shares a server resource.
         *
         * @param servername
         *            Pointer to a string that specifies the DNS or NetBIOS name
         *            of the remote server on which the function is to execute.
         *            If this parameter is NULL, the local computer is used.
         * @param level
         *            Specifies the information level of the data. This
         *            parameter can be one of the following values.<br/>
         *            2:<br/>
         *            Specifies information about the shared resource, including
         *            the name of the resource, type and permissions, and number
         *            of connections. The buf parameter points to a SHARE_INFO_2
         *            structure.
         *
         *            502:<br/>
         *            Specifies information about the shared resource, including
         *            the name of the resource, type and permissions, number of
         *            connections, and other pertinent information. The buf
         *            parameter points to a SHARE_INFO_502 structure.
         *
         *            503:<br/>
         *            Specifies information about the shared resource, including
         *            the name of the resource, type and permissions, number of
         *            connections, and other pertinent information. The buf
         *            parameter points to a SHARE_INFO_503 structure.
         * @param buf
         *            Pointer to the buffer that specifies the data. The format
         *            of this data depends on the value of the level parameter.
         *            For more information, see <a href=
         *            "http://msdn.microsoft.com/en-us/library/aa370676(v=vs.85).aspx"
         *            >Network Management Function Buffers</a>.
         * @param parm_err
         *            Pointer to a value that receives the index of the first
         *            member of the share information structure that causes the
         *            ERROR_INVALID_PARAMETER error. If this parameter is NULL,
         *            the index is not returned on error. For more information,
         *            see the NetShareSetInfo function.
         * @return If the function succeeds, the return value is NERR_Success.
         *         If the function fails, the return value can be one of the
         *         following error codes.
         */
        int NetShareAdd(String servername, int level, ShareInfo2 buf,
                        IntByReference parm_err);

        /**
         * Deletes a share name from a server's list of shared resources,
         * disconnecting all connections to the shared resource.
         *
         * @param servername
         *            Pointer to a string that specifies the DNS or NetBIOS name
         *            of the remote server on which the function is to execute.
         *            If this parameter is NULL, the local computer is used.
         * @param netname
         *            Pointer to a string that specifies the name of the share
         *            to delete. This string is Unicode if _WIN32_WINNT or
         *            FORCE_UNICODE is defined.
         * @param reversed
         *            Reserved, must be zero.
         * @return If the function succeeds, the return value is NERR_Success.
         *         If the function fails, the return value can be one of the
         *         following error codes.
         */
        int NetShareDel(String servername, String netname, int reversed);
    }

    /**
     * Deletes a share name from a server's list of shared resources,
     * disconnecting all connections to the shared resource.
     *
     * @param servername
     * @param netname
     * @return
     */
    public int netShareDel(String servername, String netname) {
        // If the function succeeds, the return value is NERR_Success
        return INSTANCE.NetShareDel(servername, netname, 0);

    }

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
    public int netShareAdd(String servername, String netname,
                                  String remark, int permissions, String path, String passwd) {
        ShareInfo2 buf = new ShareInfo2();
        buf.shi2_netname = (netname == null) ? null : new WString(netname);
        // STYPE_DISKTREE
        buf.shi2_type = 0;
        buf.shi2_remark = (remark == null) ? null : new WString(remark);
        buf.shi2_permissions = permissions;
        buf.shi2_max_uses = 1;
        buf.shi2_current_uses = 0;
        buf.shi2_path = (path == null) ? null : new WString(path);
        buf.shi2_passwd = (passwd == null) ? null : new WString(passwd);

        IntByReference parm_err = new IntByReference();

        // If the function succeeds, the return value is NERR_Success
        return INSTANCE.NetShareAdd(servername, 2, buf, parm_err);
    }

    public static int NetUserGetGroups(final String servername, final String username, final int level, final PointerByReference bufptr, final int prefmaxlen, final IntByReference entriesread, final IntByReference totalentries) {
        return INSTANCE.NetUserGetGroups(servername, username, level, bufptr, prefmaxlen, entriesread, totalentries);
    }

    public static int NetGroupEnum(final String servername, final int level, final PointerByReference bufptr, final int prefmaxlen, final IntByReference entriesread, final IntByReference totalentries, final IntByReference resume_handle) {
        return INSTANCE.NetGroupEnum(servername, level, bufptr, prefmaxlen, entriesread, totalentries, resume_handle);
    }

    public static int NetGetDCName(final String serverName, final String domainName, final PointerByReference bufptr) {
        return INSTANCE.NetGetDCName(serverName, domainName, bufptr);
    }

    public static int DsEnumerateDomainTrusts(final String serverName, final int Flags, final PointerByReference Domains, final IntByReference DomainCount) {
        return INSTANCE.DsEnumerateDomainTrusts(serverName, Flags, Domains, DomainCount);
    }

    public static int NetUserChangePassword(final String domainname, final String username, final String oldpassword, final String newpassword) {
        return INSTANCE.NetUserChangePassword(domainname, username, oldpassword, newpassword);
    }

    public static int NetApiBufferFree(final Pointer buffer) {
        return INSTANCE.NetApiBufferFree(buffer);
    }

    public static int DsGetForestTrustInformation(final String serverName, final String trustedDomainName, final int Flags, final NTSecApi.PLSA_FOREST_TRUST_INFORMATION.ByReference ForestTrustInfo) {
        return INSTANCE.DsGetForestTrustInformation(serverName, trustedDomainName, Flags, ForestTrustInfo);
    }

    public static int NetUserGetInfo(final String servername, final String username, final int level, final PointerByReference bufptr) {
        return INSTANCE.NetUserGetInfo(servername, username, level, bufptr);
    }

    public static int DsGetDcName(final String ComputerName, final String DomainName, final Guid.GUID DomainGuid, final String SiteName, final int Flags, final DsGetDC.PDOMAIN_CONTROLLER_INFO.ByReference DomainControllerInfo) {
        return INSTANCE.DsGetDcName(ComputerName, DomainName, DomainGuid, SiteName, Flags, DomainControllerInfo);
    }

    public static int NetUserGetLocalGroups(final String servername, final String username, final int level, final int flags, final PointerByReference bufptr, final int prefmaxlen, final IntByReference entriesread, final IntByReference totalentries) {
        return INSTANCE.NetUserGetLocalGroups(servername, username, level, flags, bufptr, prefmaxlen, entriesread, totalentries);
    }

    public static int NetUserEnum(final String servername, final int level, final int filter, final PointerByReference bufptr, final int prefmaxlen, final IntByReference entriesread, final IntByReference totalentries, final IntByReference resume_handle) {
        return INSTANCE.NetUserEnum(servername, level, filter, bufptr, prefmaxlen, entriesread, totalentries, resume_handle);
    }

    public static int NetUserAdd(final String servername, final int level, final Structure buf, final IntByReference parm_err) {
        return INSTANCE.NetUserAdd(servername, level, buf, parm_err);
    }

    public static int NetUserDel(final String servername, final String username) {
        return INSTANCE.NetUserDel(servername, username);
    }

    public static int NetGetJoinInformation(final String lpServer, final PointerByReference lpNameBuffer, final IntByReference BufferType) {
        return INSTANCE.NetGetJoinInformation(lpServer, lpNameBuffer, BufferType);
    }

    public static int NetLocalGroupEnum(final String serverName, final int level, final PointerByReference bufptr, final int prefmaxlen, final IntByReference entriesread, final IntByReference totalentries, final IntByReference resume_handle) {
        return INSTANCE.NetLocalGroupEnum(serverName, level, bufptr, prefmaxlen, entriesread, totalentries, resume_handle);
    }
}
