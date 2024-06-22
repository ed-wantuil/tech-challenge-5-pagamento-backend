import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
    vus: 1000,
    duration: '1m',
};

export default function () {
    let url = 'http://localhost:8080/customer?cpf=758.679.480-48';

    let res = http.get(url);
}