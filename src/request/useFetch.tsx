const url = "http://161.35.217.199:3000/"

export const performFetch = (path: string) => {
    const petition = (method: string) => (body?: unknown) =>
        fetch(url + path, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body)
        }).then(res => res.json())
    return {
        get: petition('GET'),
        post: (body: string) => petition('POST')(body)
    }
}
