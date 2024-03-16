import http from "./http-common";

const getAll = () => {
    return http.get("/sector/all");
};

const exportedObject = {
    getAll
};

export default exportedObject;

