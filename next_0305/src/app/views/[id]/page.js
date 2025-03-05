"use client"
import Item from "@/component/Item";
import axios from "axios";
import {use, useEffect, useState } from "react";
import { useParams } from "next/navigation"; // ✅ useParams() 사용

export default function Page({params}){
    const {id} = use(params);
    // 아래 두 줄 줄여서 쓴게 위쪽이고 아래 구문을 쓰려면 페이지 뒤에 인자를 받으면 안된다.
    // const params = useParams(); // ✅ params 가져오기 use파람즈 객체를 제공해주는데 이걸로 받자
    // const id = params.id; // ✅ 옵셔널 체이닝으로 안전하게 접근

     //const id = params.id;
     //const id = props.id;
    // const id = `${params.id}`;
    //보여주기용용

    const api_url = `/api/v1/products/${id}.json`;
    // 문자열 안에 변수 넣을 때 백틱 진짜 활용

    const [vo,setVO] = useState({});
    // 비어있는 제이슨 객체체
    
    // 비동기식 통신을 위한 함수

    function getData(){
        axios.get(api_url).then((res)=>{
            setVO(res.data);
        })
    }

    //현재 문서에서 id라는 변수가 바뀔 때 마다 서버호출
    useEffect(()=>{
        if(id && id>0){
            getData();
        }
    }, [id]);

    

    return(
        <div>
           <Item item={vo}></Item>
        </div>
    );
}