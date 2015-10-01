package cn.com.jautoitx.domain;

/**
 * @author: Andrzej Gdula
 * @created: 09/30/2015 20:27
 * @version: 1.0
 */

import com.sun.jna.Structure;
import com.sun.jna.WString;

import java.util.Arrays;
import java.util.List;

/**
 * Contains information about the shared resource, including name of the
 * resource, type and permissions, and the number of current connections.
 * For more information about controlling access to securable objects, see
 * Access Control, Privileges, and Securable Objects.
 *
 * @author zhengbo.wang
 */
public class ShareInfo2 extends Structure {
    /*
     * Pointer to a Unicode string specifying the share name of a resource.
     * Calls to the NetShareSetInfo function ignore this member.
     */
    public WString shi2_netname;

    /*
     * A combination of values that specify the type of the shared resource.
     * Calls to the NetShareSetInfo function ignore this member. One of the
     * following values may be specified. You can isolate these values by
     * using the STYPE_MASK value.
     */
    public int shi2_type;

    /*
     * Pointer to a Unicode string that contains an optional comment about
     * the shared resource.
     */
    public WString shi2_remark;

    /*
     * Specifies a DWORD value that indicates the shared resource's
     * permissions for servers running with share-level security. A server
     * running user-level security ignores this member. This member can be
     * one or more of the following values. Calls to the NetShareSetInfo
     * function ignore this member. Note that Windows does not support
     * share-level security.
     */
    public int shi2_permissions;

    /*
     * Specifies a DWORD value that indicates the maximum number of
     * concurrent connections that the shared resource can accommodate. The
     * number of connections is unlimited if the value specified in this
     * member is -1.
     */
    public int shi2_max_uses;

    /*
     * Specifies a DWORD value that indicates the number of current
     * connections to the resource. Calls to the NetShareSetInfo function
     * ignore this member.
     */
    public int shi2_current_uses;

    /*
     * Pointer to a Unicode string specifying the local path for the shared
     * resource. For disks, shi2_path is the path being shared. For print
     * queues, shi2_path is the name of the print queue being shared. Calls
     * to the NetShareSetInfo function ignore this member.
     */
    public WString shi2_path;

    /*
     * Pointer to a Unicode string that specifies the share's password when
     * the server is running with share-level security. If the server is
     * running with user-level security, this member is ignored. The
     * shi2_passwd member can be no longer than SHPWLEN+1 bytes (including a
     * terminating null character). Calls to the NetShareSetInfo function
     * ignore this member. Note that Windows does not support share-level
     * security.
     */
    public WString shi2_passwd;

    @SuppressWarnings("rawtypes")
    @Override
    protected List getFieldOrder() {
        return Arrays.asList("shi2_netname", "shi2_type", "shi2_remark",
                "shi2_permissions", "shi2_max_uses", "shi2_current_uses",
                "shi2_path", "shi2_passwd");
    }
}
