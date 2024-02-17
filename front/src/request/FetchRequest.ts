const url = "http://localhost"

export const  performFetch = <T>(path: string, port:string) => {
    const petition = (method: string) => (body?: unknown) => fetch(url + ":"+port +"/api/v1" + path, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body)
        }).then(res => res.json())

    return {
        get: petition('GET'),
        post: (body: T) => petition('POST')(body),
        delete: petition('DELETE')
    }
}
