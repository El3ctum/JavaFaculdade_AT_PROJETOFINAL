package br.infnet.at.user.workerUser;

import br.infnet.at.user.workerUser.WorkerUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WorkerUserService {
    private static Map<Integer, WorkerUser> WorkerUserMap = new HashMap<Integer, WorkerUser>();

    private static Integer id = 0;

    public static void insertWorkerUser(WorkerUser workerUser) {

        workerUser.setId(++id);

        WorkerUserMap.put(workerUser.getId(), workerUser);
    }

    public static void deleteWorkerUser(Integer id) {
        WorkerUserMap.remove(id);
    }

    public static Collection<WorkerUser> workerUserList() {
        return WorkerUserMap.values();
    }

    public static WorkerUser getWorkerUserById(Integer id) {
        return WorkerUserMap.get(id);
    }

    public static WorkerUser getRandomWorkerUser() {
        int size = WorkerUserMap.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * size);
        Collection<WorkerUser> workerUsers = WorkerUserMap.values();
        WorkerUser[] workerUsersArray = workerUsers.toArray(new WorkerUser[0]);
        return workerUsersArray[randomIndex];
    };

}
