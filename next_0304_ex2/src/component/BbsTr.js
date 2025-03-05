export default function BbsTr(params){

    console.log("BbsTr received data:", params);
    return(
        <tr>
            <td>{params.num}</td>
            <td>{params.title}</td>
            <td>{params.name}</td>
            <td>2025-03-04</td>
            <td>0</td>
        </tr>
    );
}