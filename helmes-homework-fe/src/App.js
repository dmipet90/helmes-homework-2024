import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import {Route, Routes} from "react-router-dom";
import CreateUser from "./component/CreateUser";
import UpdateUser from "./component/UpdateUser";

function App() {
    return (
        <div className="container">
            <div className="row">
                <Routes>
                    <Route path="/" element={<CreateUser/>}/>
                    <Route path="updateUser/:userId" element={<UpdateUser/>}/>
                </Routes>
            </div>
        </div>
    );
}

export default App;
