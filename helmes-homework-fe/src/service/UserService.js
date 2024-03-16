import http from "./http-common";

const create = (user) => {
    return http.post("/user/create", user);
};

const get = (userId) => {
    return http.get(`/user/${userId}`);
};

const update = (userId, user) => {
    return http.put(`/user/${userId}`, user);
};

const exportedObject = {
    create,
    get,
    update
};

export default exportedObject;