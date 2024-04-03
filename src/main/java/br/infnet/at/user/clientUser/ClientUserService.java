package br.infnet.at.user.clientUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientUserService {
    private static Map<Integer, ClientUser> clientUserMap = new HashMap<Integer, ClientUser>();

    private static Integer id = 0;

    public static void insertClientUser(ClientUser clientUser) {

        clientUser.setId(++id);

        clientUserMap.put(clientUser.getId(), clientUser);
    }

    public static void deleteClientUser(Integer id) {
        clientUserMap.remove(id);
    }

    public static Collection<ClientUser> clientUserList() {
        return clientUserMap.values();
    }

    public static ClientUser getClientUserById(Integer id) {
        return clientUserMap.get(id);
    }

}
