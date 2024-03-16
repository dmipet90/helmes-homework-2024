import SectorService from "../service/SectorService";
import React, {useEffect, useState} from "react";
import UserService from "../service/UserService";
import classnames from "classnames";
import {useNavigate} from "react-router-dom";

const CreateUser = () => {

    const [name, setName] = useState("");
    const [sectors, setSectors] = useState([]);
    const [sectorIds, setSectorIds] = useState([]);
    const [termsAgreed, setTermsAgreed] = useState(false);
    const [error, setError] = useState("");
    const navigate = useNavigate();


    const renderMenu = ( node ) => {
        return node.map((item) => (
            <React.Fragment key={item.name}>
                <option value={item.sectorId}>{item.name}</option>
                {item.children && renderMenu(item.children)}
            </React.Fragment>
        ))
    };

    const retrieveSectors = () => {
        SectorService.getAll()
            .then((response) => {
                setSectors(response.data)
            })
            .catch((err) => {
                setError(err.response.data)
            });
    };

    useEffect(retrieveSectors, []);

    const handleNameChange = (e) => {
        setName(e.target.value);
    }

    const handleTermsChange= () => {
        setTermsAgreed(!termsAgreed)
    }

    const handleSectorsChange= (e) => {
        setSectorIds(Array.from(e.currentTarget.selectedOptions, (v) => v.value))
    };

    const saveUser = (event) => {
        event.preventDefault();
        UserService.create({
            "name": name,
            "sectorIds": sectorIds,
            "termsAgreed": termsAgreed
        }).then((response) => {
            navigate(`/updateUser/${response.data.userId}`)
        })
        .catch((err) => {
            setError(err.response.data)
        });
    };

    return (
        <div className="col-md-6">
            <p className="mt-5">Please enter your name and pick the Sectors you are currently involved in.</p>
            <form onSubmit={saveUser} >
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input className={classnames("form-control", {
                               "is-invalid": error.name
                           })}
                           type="text"
                           id="name"
                           name="name"
                           value={name}
                           onChange={handleNameChange}/>
                    {error.name && (
                        <div className="invalid-feedback">
                            {error.name}
                        </div>
                    )}
                </div>
                <div className="mb-3">
                    <label htmlFor="sectors" className="form-label">Sectors</label>
                    <select className={classnames("form-control", {
                                "is-invalid": error.sectorIds
                            })}
                            id="sectors" multiple
                            name="sectorIds"
                            value={sectorIds}
                            onChange={handleSectorsChange}>
                        {renderMenu(sectors)}
                    </select>
                    {error.sectorIds && (
                        <div className="invalid-feedback">
                            {error.sectorIds}
                        </div>
                    )}
                </div>
                <div className="form-check mb-3">
                    <div className="checkbox">
                        <input className={classnames("form-check-input", {
                                "is-invalid": error.termsAgreed
                            })}
                            type="checkbox"
                            id="terms"
                            name="termsAgreed"
                            checked={termsAgreed}
                            onChange={handleTermsChange}/>
                        <label className="form-check-label" htmlFor="terms">
                            Agree to terms
                        </label>
                        {error.termsAgreed && (
                            <div className="invalid-feedback">
                                {error.termsAgreed}
                            </div>
                        )}
                    </div>
                </div>
                <button type="submit" className="btn btn-outline-secondary mb-3">Save</button>
            </form>
        </div>
    );
}
export default CreateUser;