import InformationContent from "../../components/InformationContent";
import Template from "../Template.tsx";
import Title from "../../components/Title";
import Typography from "@mui/material/Typography";
import ComponentSkeleton from "../../components/ComponentSkeleton";


export default function DashboardContent() {
    return (
        <Template>
            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={6} sm={12} md={12} xs={12}  gridTemplateColumns={'1fr'}>
                    <InformationContent>
                        <Title>
                            Desarrollo de un front-end utilizando React
                        </Title>
                        <Typography color={"text.primary"} paddingTop={4} variant={"overline"}>
                            Master en Ingenieria de software y sistemas informaticos
                        </Typography>
                        <Typography color="text.primary" sx={{flex: 1}}>
                            Kevin Santiago Rey Rodriguez
                        </Typography>
                        <Typography paddingTop={4} color="text.secondary">
                            Diciembre, 2023
                        </Typography>
                    </InformationContent>
            </ComponentSkeleton>

            <ComponentSkeleton paddingTop={4} paddingBottom={2}  lg={6} sm={12} md={12} xs={12}  gridTemplateColumns={'1fr'}>
                    <InformationContent>
                        <Title>Descripcion del trabajo</Title>
                        <Typography>
                            El proyecto implica el desarrollo del front-end de una aplicación web.
                            El uso de React es fundamental, incluyendo la creación de componentes funcionales JSX, y la implementación de custom hooks. También se debe integrar React Router para gestionar diferentes rutas en la aplicación.
                        </Typography>
                        <Typography>
                            Se valorará el uso de datos de prueba y el despliegue del front-end usando herramientas como Vercel.
                        </Typography>
                    </InformationContent>
            </ComponentSkeleton>

            <ComponentSkeleton paddingTop={4} paddingBottom={2} lg={12} gridTemplateColumns={'1fr'}>
                    <InformationContent>
                        <Title>Características del Proyecto</Title>
                        <Typography variant={"overline"}>
                            Componentes React
                        </Typography>
                        <Typography >
                            Incluye componentes para la navegación, listado de productos, detalles de productos, carrito de compras y la interfaz de usuario para realizar pedidos.
                        </Typography >
                        <Typography variant={"overline"} paddingTop={2}>
                            Estilos y Diseño
                        </Typography>
                        <Typography >
                            Con Material-UI y Emotion, la aplicación presenta un diseño limpio y responsive, asegurando una buena experiencia de usuario en diferentes dispositivos.
                        </Typography>
                        <Typography variant={"overline"} paddingTop={2}>
                            Funcionalidades de la Tienda
                        </Typography>
                        <Typography >
                            Incluye la visualización de productos, búsqueda y filtrado de productos, visualización de detalles de productos y la gestión de un carrito de compras.
                        </Typography>
                        <Typography variant={"overline"} paddingTop={2}>
                            Datos y Manejo del Estado
                        </Typography>
                        <Typography >
                            Maneja el estado de los componentes y efectos secundarios utilizando hooks como useState y useEffect, para la obtención de datos de productos y la actualización de la interfaz de usuario.
                        </Typography>
                        <Typography variant={"overline"} paddingTop={2}>
                            Routing y Navegación
                        </Typography>
                        <Typography >
                            Utiliza React Router para manejar las rutas dentro de la aplicación, facilitando la navegación entre diferentes páginas como la página de inicio, catálogo de productos, detalles de productos y el carrito de compras.
                        </Typography>
                    </InformationContent>
            </ComponentSkeleton>
        </Template>
    );
}